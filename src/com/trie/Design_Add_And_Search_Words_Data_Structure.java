package com.trie;

public class Design_Add_And_Search_Words_Data_Structure {

	public static void main(String[] args) {

	}

}

class WordDictionary {

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.isEnd = false;
	}

	public boolean search(String word) {
		
		return true;
	}
}

class TrieNode {

	TrieNode[] children;
	boolean isEnd;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.isEnd = false;
	}

}