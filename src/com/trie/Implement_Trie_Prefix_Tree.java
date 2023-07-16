package com.trie;

public class Implement_Trie_Prefix_Tree {

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("delhi");
		trie.insert("jaipur");
		trie.insert("mumbai");

		System.out.println(trie.search("delhi"));
		System.out.println(trie.startsWith("gur"));
		System.out.println(trie.startsWith("jai"));
		
		trie.insert("pune");
		trie.insert("gurgaon");

		System.out.println(trie.startsWith("gur"));
		System.out.println(trie.search("gurgaon"));
	}

}

class TriNode {
	TriNode[] children = new TriNode[26];
	boolean isEnd = false;
}

class Trie {

	TriNode root;

	public Trie() {
		root = new TriNode();
	}

	public void insert(String word) {
		TriNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TriNode();
			}
			node = node.children[c - 'a'];
		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		TriNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
		}
		return node.isEnd;
	}

	public boolean startsWith(String prefix) {
		TriNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
		}
		return true;
	}
}