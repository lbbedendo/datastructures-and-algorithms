package trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        var current = root;
        word = word.toLowerCase();

        for (char l: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean contains(String word) {
        var current = root;
        word = word.toLowerCase();

        for (char l: word.toCharArray()) {
            var node = current.getChildren().get(l);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public void remove(String word) {
        word = word.toLowerCase();
        remove(root, word, 0);
    }

    private boolean remove(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char l = word.charAt(index);
        var node = current.getChildren().get(l);
        if (node == null) {
            return false;
        }
        boolean shouldRemoveCurrentNode = remove(node, word, index + 1) && !node.isEndOfWord();

        if (shouldRemoveCurrentNode) {
            current.getChildren().remove(l);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public boolean isEmpty() {
        return root.getChildren().isEmpty();
    }
}
