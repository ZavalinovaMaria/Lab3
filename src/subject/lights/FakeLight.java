package subject.lights;

import subject.*;

public final class FakeLight extends Light {
    public FakeLight(String name, int seconds) {
        super(name, seconds);
        brightness = 100;
        period = 0;

    }
    public void shine(Subjects subject, Tree tree, Tree.Branch branch) {
        System.out.printf("%s %s на груду..(%s?).. поваленных %s и %s ", name, lightCharacteristic(), subject, tree, branch);
        System.out.println();
        shineToSubject(subject);
        shineToTree(tree);
        shineToTree(branch);
    }
}

