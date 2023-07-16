package com.trie;

public class Design_Add_And_Search_Words_Data_Structure {

	public static void main(String[] args) {
		
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("delhi");
		wordDictionary.addWord("mumbai");
		wordDictionary.addWord("gurgaon");
		System.out.println(wordDictionary.search("d.lhi"));
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
		node.isEnd = true;
	}

	public boolean search(String word) {

		if (word == null || word.length() == 0)
			return false;
		TrieNode node = root;
		return searchHelperMethod(word, 0, node);

	}

	private boolean searchHelperMethod(String word, int index, TrieNode node) {
		if (node == null)
			return false;
		if (index == word.length())
			return node.isEnd;
		char c = word.charAt(index);
		if (c == '.') {
			for (int i = 0; i < 26; i++) {
				if (searchHelperMethod(word, index + 1, node.children[i]))
					return true;
			}
		} else {
			if (searchHelperMethod(word, index + 1, node.children[c - 'a']))
				return true;
		}
		return false;
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