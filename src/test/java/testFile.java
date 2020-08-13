import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class testFile {
    @Test
    public void testFileOnePathNull() {
        String filePath1 = "\n";
        InputStream inStream = System.in;
        FileReadAndWrite f = new FileReadAndWrite();
        try {
            System.setIn(new ByteArrayInputStream(filePath1.getBytes()));
            assertFalse("来根华子冷静一下", f.getFilePath());
        } finally {
            System.setIn(inStream);
        }
    }

    @Test
    public void testFileNotExist() {
        String path = System.getProperty("user.dir") + "\n";
        InputStream inStream = System.in;
        FileReadAndWrite f = new FileReadAndWrite();
        try {
            System.setIn(new ByteArrayInputStream(path.getBytes()));
            assertFalse("来根华子冷静一下", f.getFilePath());
        } finally {
            System.setIn(inStream);
        }
    }

    @Test
    public void testFileOverSize() throws IOException {
        String path = System.getProperty("user.dir") + "\\allTestFiles\\BigFile.txt";
        File testFile = new File(path);
        FileReadAndWrite f = new FileReadAndWrite();
        assertNull("来根华子冷静一下", f.readFile(testFile));
    }

    @Test
    public void testFileWritePathNotExist() {
        String path = "\n";
        InputStream stdin = System.in;
        FileReadAndWrite f = new FileReadAndWrite();
        try {
            System.setIn(new ByteArrayInputStream(path.getBytes()));
            assertNull("来根华子冷静一下", f.writeStringToPath(path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) throws IOException {
        testFile t = new testFile();
        t.testFileWritePathNotExist();//写入路径为空
        t.testFileOverSize();//读取文件过大
        t.testFileOnePathNull();//读取文件为空
        t.testFileNotExist();//读取路径下无文件
    }

}
