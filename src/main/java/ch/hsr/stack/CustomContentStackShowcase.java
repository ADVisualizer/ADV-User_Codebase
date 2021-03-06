package ch.hsr.stack;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.ADVModule;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.stack.model.Stack;

public class CustomContentStackShowcase {

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        ADVStack<StackContent> stack = new Stack<>();
        ADVModule module = new StackModule("Stack", stack);

        stack.push(new StackContent(1, "1", "2"));
        stack.push(new StackContent(2, "abc", "efg"));
        ADV.snapshot(module, "Pushed initial entries");

        stack.pop();
        ADV.snapshot(module, "Popped entry");

        stack.push(new StackContent(3, "33", "what?"));
        ADV.snapshot(module, "Pushed third entry");

        stack.top();
        ADV.snapshot(module, "Top does not change the stack values");
    }

    private static class StackContent {
        int id;
        String value1;
        String value2;

        public StackContent(int id, String value1, String value2) {
            this.id = id;
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return id + ": " + value1 + ", " + value2;
        }
    }
}

