// This file was mostly written with chat gpt... :)

package com.uji.misc.jsonvisualizer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;

public class JSONVisualizer {
		public final String input;

		public JSONVisualizer(String i) {
			input = i;
		}

    public void visualize() {
        String jsonContent = input;

        // Parse the JSON content using Jackson ObjectMapper
        JsonNode jsonNode = parseJson(jsonContent);

        if (jsonNode != null) {
            // Visualize the JSON using JTree
            visualizeJson(jsonNode);
        } else {
            System.err.println("Failed to parse the JSON.");
        }
    }

    // Method to parse JSON string into JsonNode
    private static JsonNode parseJson(String jsonContent) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(jsonContent);
        } catch (IOException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }

    // Method to visualize the JSON as a JTree
    private static void visualizeJson(JsonNode rootNode) {
        // Convert JSON to a tree-like structure
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("JSON");
        buildTree(root, rootNode);

        // Create a JTree from the DefaultMutableTreeNode
        JTree tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);

        // Set up the JFrame to show the JTree
        JFrame frame = new JFrame("JSON Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    // Helper method to build the tree recursively
    private static void buildTree(DefaultMutableTreeNode parentNode, JsonNode node) {
        if (node.isObject()) {
            node.fieldNames().forEachRemaining(fieldName -> {
                JsonNode fieldValue = node.get(fieldName);
                DefaultMutableTreeNode fieldNode = new DefaultMutableTreeNode(fieldName);
                parentNode.add(fieldNode);
                buildTree(fieldNode, fieldValue);
            });
        } else if (node.isArray()) {
            for (JsonNode arrayElement : node) {
                DefaultMutableTreeNode arrayNode = new DefaultMutableTreeNode("Array Element");
                parentNode.add(arrayNode);
                buildTree(arrayNode, arrayElement);
            }
        } else {
            parentNode.add(new DefaultMutableTreeNode(node.asText()));
        }
    }
}
