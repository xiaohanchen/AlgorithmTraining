package Draft;

public class StringDraft {


    public static void main(String[] args) {



        //splits (\n all dispeard)
        String stringDoc = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String[] strings = stringDoc.split("\n");




        String string2 = "cxhcxhcxhg\t";
        int num = string2.lastIndexOf("\t");


        //TODO appear nums

        String parent = "cxhdtcdtcndtcdtc";
        String kid = "dtc";

        int index = parent.indexOf(kid);
        String subParent = parent.substring(index, index + kid.length());    //count in START, count out END
        String[] splitted = parent.split(kid);







        //TODO STRING BUFFER
        StringBuffer sb = new StringBuffer("cxh");
        sb.append(666);
        sb.append("haha");

        sb.reverse();
        System.out.println(sb);

        return;

    }
}
