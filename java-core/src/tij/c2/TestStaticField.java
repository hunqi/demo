package tij.c2;

public class TestStaticField {

    public static void main(String[] args) {
        Chinese xiaoMing = new Chinese("xiaoMing", "HeBei");
        Chinese xiaoHong = new Chinese("xiaoHong", "ShanXi");

        System.out.println("xiaoMing's language is: " + xiaoMing.getLanguage());
        System.out.println("xiaoHong's language is: " + xiaoHong.getLanguage());
    }

}

class Chinese {
    static  String language = "mandarin";
    String name;
    String province;

    public Chinese(String name, String province) {
        this.name = name;
        this.province = province;
    }

    String getLanguage(){
        return language;
    }

}
