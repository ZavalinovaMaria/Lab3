package humans.interfaces;

import exception.InvalidValueException;
import subject.Subjects;

public interface TakeToArm {
    void takeToRightArm(Subjects... s)throws InvalidValueException;
    void takeToLeftArm(Subjects... s)throws InvalidValueException;
    void replaceSubjects();
}
