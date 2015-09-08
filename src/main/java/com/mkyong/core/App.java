package com.mkyong.core;

import com.mongodb.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try{
            MongoClient mongo = new MongoClient("localhost", 27017);

            DB db = mongo.getDB("mydb");

            DBCollection table = db.getCollection("user");

            BasicDBObject document = new BasicDBObject();

            document.put("name","Ha hhhhhh");
            table.insert(document);

            /**** Find and display */
            BasicDBObject searchObject = new BasicDBObject();
            searchObject.put("name","Ha hhhhhh");
            DBCursor cursor = table.find(searchObject);
            while(cursor.hasNext()){
                System.out.print(cursor.next());
            }

            // Updated
            BasicDBObject updateQuery  = new BasicDBObject();
            updateQuery.put("name","Ha hhhhhh");
            BasicDBObject newDocment = new BasicDBObject();
            newDocment.put("name","trungdinh0519");
            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocment);

            table.update(updateQuery,updateObj);

            System.out.println("Updated");
            searchObject = new BasicDBObject();
            searchObject.put("name","trungdinh0519");
            cursor = table.find(searchObject);
            while(cursor.hasNext()){
                System.out.print(cursor.next());
            }


        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
