package trie;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class AutoCompleteTrie extends Trie {
    private List<String> wordList;

    public AutoCompleteTrie() {
        super();
    }

    public List<String> search(String key) {
        this.wordList = new ArrayList<>();
        var current = this.root;
        var tempWord = new StringBuilder();

        for (char l: key.toCharArray()) {
            if (!current.getChildren().containsKey(l)) {
                return emptyList();
            }

            tempWord.append(l);
            current = current.getChildren().get(l);
        }

        if (current.isEndOfWord() && !current.getChildren().isEmpty()) {
            return emptyList();
        }

        search(current, tempWord.toString());

        return wordList;
    }

    private void search(TrieNode current, String word) {
        if (current.isEndOfWord()) {
            this.wordList.add(word);
        }
        current.getChildren().forEach((character, trieNode) -> {
            search(trieNode, word + character);
        });
    }
}
