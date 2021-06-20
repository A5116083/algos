package com.company.dynamic;

public class ExcelColumMapper {

    public static void main(String[] args) {

        Excel excel = new Excel();
        System.out.println(excel.getColumn(26));

        System.out.println(excel.getColumn(51));



    }

    static class Excel{

        public  String getColumn(int column){

            StringBuilder stringBuilder = new StringBuilder();

            while (column >0){

                int rem = column%26;

                if(rem== 0){
                    stringBuilder.append("Z");
                    column = (column/26) -1;

                }else{


                    stringBuilder.append((char)((rem - 1) + 'A'));
                    column = column/26;
                }
            }
            String str=  stringBuilder.reverse().toString();
            return str;
        }
    }
}
