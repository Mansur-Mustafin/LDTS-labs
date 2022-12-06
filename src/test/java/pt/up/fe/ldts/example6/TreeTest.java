package pt.up.fe.ldts.example6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TreeTest {
    private Tree tree;
    private Date date;

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        date = sdf.parse("31-08-2002 10:20:56");
        tree = new Tree(date, "41.177772696363114", "-8.59843522310257", "FEUP");
    }

    @Test
    public void testTreeCreation() {
        Assertions.assertEquals(tree.plantedAt, date);
        Assertions.assertEquals("41.177772696363114", tree.locationLatitude);
        Assertions.assertEquals("-8.59843522310257", tree.locationLongitude);
        Assertions.assertEquals("FEUP", tree.locationName);
    }

    @Test
    public void testTreeSetLocation() {
        tree.setLocation("loclat", "loclon", "locname");
        Assertions.assertEquals(tree.plantedAt, date);
        Assertions.assertEquals("loclat", tree.locationLatitude);
        Assertions.assertEquals("loclon", tree.locationLongitude);
        Assertions.assertEquals("locname", tree.locationName);
    }

    @Test
    public void testToString() {
        String result = tree.toString();
        Assertions.assertEquals("Tree planted at Sat Aug 31 10:20:56 GMT 2002 in location 41.177772696363114,-8.59843522310257 (FEUP)", result);
    }

    @Test
    public void testAddAppraisal() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date appraisalDate = sdf.parse("31-08-2002 10:20:56");

        Assertions.assertEquals(0, tree.getAppraisals().size());
        tree.addAppraisal(appraisalDate);
        Assertions.assertEquals(1, tree.getAppraisals().size());
    }

    @Test
    public void testNextAppraisalOverdue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -6);
        Date appraisalDate = calendar.getTime();

        Assertions.assertFalse(tree.isNextAppraisalOverdue());
        tree.addAppraisal(appraisalDate);
        Assertions.assertTrue(tree.isNextAppraisalOverdue());
    }

    @Test
    public void testNextAppraisalNotOverdue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date appraisalDate = calendar.getTime();

        Assertions.assertFalse(tree.isNextAppraisalOverdue());
        tree.addAppraisal(appraisalDate);
        Assertions.assertFalse(tree.isNextAppraisalOverdue());
    }

}
