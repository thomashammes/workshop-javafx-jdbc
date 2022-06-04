package model.entities;

import java.util.ArrayList;

public class HuffmanTree {

	private HuffmanNode root;
	private ArrayList<HuffmanNode> list;
	private ArrayList<HuffmanNode> tree;

	public HuffmanTree(HuffmanNode node) {
		root = node;
		list = new ArrayList<>();
	}

	public HuffmanTree() {
		list = new ArrayList<>();
	}

	public HuffmanNode getRoot() {
		return root;
	}

	public void setRoot(HuffmanNode root) {
		this.root = root;
	}

	public ArrayList<HuffmanNode> getList() {
		return list;
	}

	public void setList(ArrayList<HuffmanNode> list) {
		this.list = list;
	}

	public HuffmanNode addNodeToTree(HuffmanNode current, HuffmanNode insert) {
		if (current == null) {
			return new HuffmanNode(insert);
		}

		if (insert.getFrequency() < current.getFrequency()) {
			current.setLeft(addNodeToTree(current.getLeft(), insert));
		} else if (insert.getFrequency() > current.getFrequency()) {
			current.setRight(addNodeToTree(current.getRight(), insert));
		} else {
			return current;
		}

		return current;
	}

	public void listFrequency(String testCase) {
		for (int i = 0; i < testCase.length(); i++) {
			boolean foundEqual = false;
			for (HuffmanNode node : list) {
				if (testCase.charAt(i) == node.getData()) {
					node.setFrequency(node.getFrequency() + 1);
					foundEqual = true;
				}
			}
			if (!foundEqual) {
				list.add(new HuffmanNode(1, testCase.charAt(i)));
			}
		}
	}

	public void sortList() {
		boolean sorted = false;
		HuffmanNode aux;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).getFrequency() > list.get(i + 1).getFrequency()) {
					aux = list.get(i);
					list.remove(i);
					list.add(i + 1, aux);
					sorted = false;
				}
			}
		}
	}

	public void printList(ArrayList<HuffmanNode> list) {
		System.out.println();
		for (HuffmanNode node : list) {
			System.out.println(list.indexOf(node) + ". " + node.getFrequency() + ", " + node.getData());
		}
	}
	
	public void adjustTreePosition() {
		boolean adjusted = false;
	}

	public void listToTree() {
		tree = list;
		while (tree.size() != 1) {
			System.out.println("Tree size: " + tree.size());
			HuffmanNode newNode = new HuffmanNode(tree.get(0).getFrequency() + tree.get(1).getFrequency(), null, tree.get(0), tree.get(1));
			tree.remove(0);
			tree.remove(0);
			addToTree(newNode);
			printList(tree);
		}
		root = tree.get(0);
	}

	public void addToTree(HuffmanNode newNode) {
		if (tree.size() != 0) {
			for (int i = 0; i < tree.size()-2; i++) {
				if (newNode.getFrequency() < tree.get(i+1).getFrequency()) {
					tree.add(i+1, newNode);
					return;
				}
			}
			tree.add(newNode);
			return;
		} else {
			tree.add(newNode);
			return;
		}
	}
	
	public void printTree(HuffmanNode current) {
		System.out.println(current);
		if (current.getLeft() != null) {
			printTree(current.getLeft());			
		}
		if (current.getRight() != null) { 
			printTree(current.getRight());			
		}
	}
}
