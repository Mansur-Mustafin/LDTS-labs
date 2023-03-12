import org.example.StringCaseChanger;
import org.example.StringDrink;
import org.example.StringInverter;
import org.example.StringReplacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndoTest {
    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        si.execute(drink); // DcBa-dCbA
        cc.execute(drink); // dCbA-DcBa
        sr.execute(drink); // dCbX-DcBa
        sr.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());
        cc.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());
        si.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());
    }
}
