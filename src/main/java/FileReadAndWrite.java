import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileReadAndWrite {

    private static File readFile;

    public boolean getFilePath() {
        System.out.println("请输入要读取的文件路径:");
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        if (inputString.equals("")) {
            System.out.println("空输入");
            return false;
        }
        readFile = new File(inputString);
        if (readFile.isDirectory()) {
            System.out.println("输入路径下啥也没有");
            return false;
        }
        System.out.println("输入的文件路径是:" + readFile.getAbsolutePath());
        return true;
    }

    public String readFile(File rFile) throws IOException {
        if (rFile == null) {
            System.out.println("文件未找到");
            return null;
        }
        String readFileName = FilenameUtils.getName(rFile.toString());
        System.out.println("要读取的文件是：" + readFileName);
        String encoding = "UTF-8";
        String readString = FileUtils.readFileToString(rFile, encoding);
        if (readString.length() > 10) {
            System.out.println("文件过大");
            return null;
        }
        System.out.println("读出来一句: " + readString);
        return readString;
    }

    public String writeStringToPath(String readString) throws IOException {
        System.out.println("请输入要写入的文件路径");
        Scanner writePath = new Scanner(System.in);
        String whereWrite = writePath.nextLine();
        if (whereWrite.equals("")) {
            System.out.println("没输入要写哪儿");
            return null;
        }
        File writeFile = new File(writePath.nextLine());
        System.out.println("请输入要追加的话");
        Scanner whatToWrite = new Scanner(System.in);
        FileUtils.write(writeFile, readString + whatToWrite.nextLine());
        System.out.println("文件写入成功，请检查");
        return "成功结束";
    }

    public static void main(String[] args) throws IOException {
        FileReadAndWrite f = new FileReadAndWrite();
        f.getFilePath();
        String read = f.readFile(readFile);
        f.writeStringToPath(read);
    }
}
