package com.fundation.search.model;

import com.fundation.search.model.asset.Asset;
import com.fundation.search.model.asset.FileResult;
import com.fundation.search.model.asset.FolderResult;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTestPrivateMethods {
    private Search search;
    private List<Asset> assetList;

    @Before
    public void init() {
        assetList = new ArrayList<>();
        search = new Search();
        assetList.add(new FolderResult("test\\com\\fundation\\search\\model\\filesTest\\test1", "test1"
                , 0L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, true, 9));
        assetList.add(new FolderResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs", "docs"
                , 4096L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, true, 5));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\blacks-factors-influence-estimation-supplement.pdf", "blacks-factors-influence-estimation-supplement.pdf"
                , 11864L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, ".pdf", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\Diagram.jpeg", "Diagram.jpeg"
                , 180350L, true, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, ".jpeg", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\images.jpg", "images.jpg"
                , 8148L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , true, false, false, ".jpg", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\Practice_03.docx", "Practice_03.docx"
                , 105295L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , true, false, false, ".jpg", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\Task3.txt", "Task3.txt"
                , 2995L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, ".txt", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\test1.1.txt", "test1.1.txt"
                , 6L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, ".txt", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\WorkPlans.doc", "WorkPlans.doc"
                , 67072L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, ".doc", ""));
        assetList.add(new FileResult("test\\com\\fundation\\search\\model\\filesTest\\test1\\docs\\LAB - BAP Ticketing.docx", "LAB - BAP Ticketing.docx"
                , 67072L, false, null, null, null, "DESKTOP-CPNM9MO\\Ariel Gonzales"
                , false, false, false, ".docx", ""));
    }

    @Test
    public void testSearchByPath() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByPath", "test\\com\\fundation\\search\\model\\filesTest");
            assertEquals(assetList.get(0).getPathFile(), assetList1.get(0).getPathFile());
            assertEquals(assetList.get(1).getPathFile(), assetList1.get(1).getPathFile());
            assertEquals(assetList.get(2).getPathFile(), assetList1.get(2).getPathFile());
            assertEquals(assetList.get(3).getPathFile(), assetList1.get(3).getPathFile());
            assertEquals(assetList.get(4).getPathFile(), assetList1.get(4).getPathFile());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testSearchByNameAllWords() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByName", assetList, "Task3.txt", "all words");
            assertEquals(assetList.get(0).getName(), assetList1.get(0).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchByNameStartWith() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByName", assetList, "t", "start with");
            assertEquals(assetList.get(0).getName(), assetList1.get(0).getName());
            assertEquals(assetList.get(1).getName(), assetList1.get(1).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchByNameEndWith() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByName", assetList, "t", "end with");
            assertEquals(assetList.get(0).getName(), assetList1.get(0).getName());
            assertEquals(assetList.get(1).getName(), assetList1.get(1).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchByNameEqualTo() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByName", assetList, "images.jpg", "equal to");
            assertEquals(assetList.get(0).getName(), assetList1.get(0).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchBySizeLower() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchBySize", assetList, 2995L, "lower");
            assertEquals(assetList.get(0).getSizeFile(), assetList1.get(0).getSizeFile());
            assertEquals(assetList.get(7).getSizeFile(), assetList1.get(1).getSizeFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchBySizeUpper() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchBySize", assetList, 8148L, "upper");
            assertEquals(assetList.get(2).getSizeFile(), assetList1.get(0).getSizeFile());
            assertEquals(assetList.get(3).getSizeFile(), assetList1.get(1).getSizeFile());
            assertEquals(assetList.get(5).getSizeFile(), assetList1.get(2).getSizeFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchBySizeEqual() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchBySize", assetList, 180350L, "equal");
            assertEquals(assetList.get(3).getSizeFile(), assetList1.get(0).getSizeFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchHiddenFilesOnlyHidden() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchHiddenFiles", assetList, "only hidden");
            assertEquals(assetList.get(0).getIsHidden(), assetList1.get(0).getIsHidden());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchHiddenFilesWithoutHidden() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchHiddenFiles", assetList, "without hidden");
            assertEquals(assetList.get(0).getIsHidden(), assetList1.get(0).getIsHidden());
            assertEquals(assetList.get(1).getIsHidden(), assetList1.get(1).getIsHidden());
            assertEquals(assetList.get(2).getIsHidden(), assetList1.get(2).getIsHidden());
            assertEquals(assetList.get(4).getIsHidden(), assetList1.get(4).getIsHidden());
            assertEquals(assetList.get(5).getIsHidden(), assetList1.get(5).getIsHidden());
            assertEquals(assetList.get(6).getIsHidden(), assetList1.get(6).getIsHidden());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsFileSystem() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "isFileSystem", assetList);
           /* assertEquals(assetList.get(0).getSizeFile(), assetList1.get(0).getSizeFile());
            assertEquals(assetList.get(1).getSizeFile(), assetList1.get(1).getSizeFile());
            assertEquals(assetList.get(2).getSizeFile(), assetList1.get(2).getSizeFile());
            assertEquals(assetList.get(4).getSizeFile(), assetList1.get(4).getSizeFile());
            assertEquals(assetList.get(5).getSizeFile(), assetList1.get(5).getSizeFile());
            assertEquals(assetList.get(6).getSizeFile(), assetList1.get(6).getSizeFile());*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchByDirectory() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByDirectory", assetList);
            assertEquals(assetList.get(0).getIsDirectory(), assetList1.get(0).getIsDirectory());
            assertEquals(assetList.get(1).getIsDirectory(), assetList1.get(1).getIsDirectory());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchByExtension() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByExtension", assetList, ".pdf");
            assertEquals(assetList.get(2).getExtensionFile(), assetList1.get(0).getExtensionFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchKeySensitive() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchKeySensitive", assetList, "blacks-factors-influence-estimation-supplement.pdf");
            assertEquals(assetList.get(2).getName(), assetList1.get(0).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchIntoFile() {
       /* List<Asset> assetList1;
        try {
            //assetList.forEach(e -> System.out.println(e.getName()));
            assetList1 = Whitebox.invokeMethod(search, "searchIntoFile", assetList, "katas");
            assetList1.forEach(e -> System.out.println(e.getName()));
            //assertEquals(assetList.get(6).getName(), assetList1.get(6).getName());
            //assertEquals(assetList.get(1).getSizeFile(), assetList1.get(1).getSizeFile());

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void testSearchKeySentive() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByOwner", assetList, "DESKTOP-CPNM9MO\\Ariel Gonzales");
            assertEquals(assetList.get(0).getOwnerFile(), assetList1.get(0).getOwnerFile());
            assertEquals(assetList.get(1).getOwnerFile(), assetList1.get(1).getOwnerFile());
            assertEquals(assetList.get(2).getOwnerFile(), assetList1.get(2).getOwnerFile());
            assertEquals(assetList.get(3).getOwnerFile(), assetList1.get(3).getOwnerFile());
            assertEquals(assetList.get(4).getOwnerFile(), assetList1.get(4).getOwnerFile());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchFilter() {
        List<Asset> assetList1;
        try {
            assetList1 = Whitebox.invokeMethod(search, "searchByOwner", assetList, "DESKTOP-CPNM9MO\\Ariel Gonzales");
            assertEquals(assetList.get(0).getOwnerFile(), assetList1.get(0).getOwnerFile());
            assertEquals(assetList.get(1).getOwnerFile(), assetList1.get(1).getOwnerFile());
            assertEquals(assetList.get(2).getOwnerFile(), assetList1.get(2).getOwnerFile());
            assertEquals(assetList.get(3).getOwnerFile(), assetList1.get(3).getOwnerFile());
            assertEquals(assetList.get(4).getOwnerFile(), assetList1.get(4).getOwnerFile());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}