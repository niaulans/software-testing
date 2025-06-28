package dropdown;

import static org.testng.Assert.*;


import org.testng.annotations.Test;

import base.BaseTests;

public class DropdownTests extends BaseTests{

    @Test
    public void testSelectedOption() {
        var dropdownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropdownPage.selectFromDropDown(option);
        var selectedOptions = dropdownPage.getSelectedOption();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

    }   
}
