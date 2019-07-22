package Mysql;

import Game.String3;

import java.sql.*;

public class JDBC {

    // 存储fight的数据
    public static void updateFightTab(int playerId, int winOrNot){
        try {
            System.out.println("存储fight的数据" + playerId + " " + winOrNot);
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://localhost:3306/EscapistChess?useSSL=false&serverTimezone=GMT%2B8&amp";
            Connection conn = DriverManager.getConnection(url,"root","");
            //"select * from tab1 where name=?";
            PreparedStatement pstmt = conn.prepareStatement("insert into fight(player,result) values(?,?)");
            pstmt.setInt( 1,playerId);
            pstmt.setInt( 2,winOrNot);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 查找每个表的数据一共多少条
    public static int queryTabRowNum(String tabName){
        int a = 0;
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://localhost:3306/EscapistChess?useSSL=false&serverTimezone=GMT%2B8&amp";
            Connection conn = DriverManager.getConnection(url,"root","");
            //"select * from tab1 where name=?";
            PreparedStatement pstmt = conn.prepareStatement("select id from " + tabName);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                a++;
            }
            pstmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

    // 查找1-4表的name， hp， atk
    public static String3 queryTab1234(String tabName, int id){
        String3 S3 = new String3("qwe", "qwe", "qwe");
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://localhost:3306/EscapistChess?useSSL=false&serverTimezone=GMT%2B8&amp";
            Connection conn = DriverManager.getConnection(url,"root","");
            //"select name,hp,atk from boss where id=?";
            PreparedStatement pstmt = conn.prepareStatement("select name,hp,atk from " + tabName + " where id=?");
            pstmt.setString( 1,String.valueOf(id) );
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                S3.setValue(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            pstmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return S3;
    }

    // 查找地图表
    public static int[] queryTabMap(int id){
        int[] a = new int[9];
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://localhost:3306/EscapistChess?useSSL=false&serverTimezone=GMT%2B8&amp";
            Connection conn = DriverManager.getConnection(url,"root","");
            //"select no1,no2,no3,no4,no5,no6,no7,no8,no9 from map where id=?";
            PreparedStatement pstmt = conn.prepareStatement("select no1,no2,no3,no4,no5,no6,no7,no8,no9 from map where id=?");
            pstmt.setString( 1,String.valueOf(id) );
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                a[0] = rs.getInt(1);
                a[1] = rs.getInt(2);
                a[2] = rs.getInt(3);
                a[3] = rs.getInt(4);
                a[4] = rs.getInt(5);
                a[5] = rs.getInt(6);
                a[6] = rs.getInt(7);
                a[7] = rs.getInt(8);
                a[8] = rs.getInt(9);
            }
            pstmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        for (int temp : a) {
            System.out.println(temp);
        }
        return a;
    }

}
