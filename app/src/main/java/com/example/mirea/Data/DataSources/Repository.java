package com.example.mirea.Data.DataSources;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.mirea.Data.DataSources.Files.AppSpecificDataSource;
import com.example.mirea.Data.DataSources.Files.CommonFilesDataSource;
import com.example.mirea.Data.DataSources.Room.AppDatabase;
import com.example.mirea.Data.DataSources.Room.DAO.ListDAO;
import com.example.mirea.Data.DataSources.Room.Entities.Category;
import com.example.mirea.Data.DataSources.SP.SharedPreferencesDS;
import com.example.mirea.Data.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repository {
    private AppSpecificDataSource appSpecDataSource;
    private  CommonFilesDataSource commonFilesDataSource;
    private SharedPreferencesDS Localds;

    public Repository() {}
    public Repository(Context context, String appSpecDSFileName, String commonFDSFileName) {
        this.appSpecDataSource = new AppSpecificDataSource(context, appSpecDSFileName);

    }
    public void writeAppSpecDS(String inputContent) {
        appSpecDataSource.writeAppSpecificDS("\n" + inputContent);
    }
    public String readAppSpecDS() {
        return appSpecDataSource.readAppSpecificDS();
    }

    private LocalDataSource dataSource = new LocalDataSource();
    public LiveData<List<Item>> getListItems() {
        return dataSource.getListItems();
    }

    public boolean writeCommonFileDS(String inputContent){
        return commonFilesDataSource.writeContent("\n" + inputContent);
    }
    public String readCommonFilesDS() {
        return commonFilesDataSource.readFile();
    }


    public void createLocalds(Context context) {
        if (Localds == null) {
            Localds = new SharedPreferencesDS(context);}
    }
    public String getLocalName() {
        if (Localds == null) return null;
        else return Localds.getString("Name");
    }

    public Integer getLocalImg() {
        if (Localds == null) return null;
        else return Localds.getInt("Img");
    }
    public void setLocalName(String name) {
        if (Localds == null) return;
        else Localds.writeString("Name", name);
    }
    public void setLocalImg(int img) {
        if (Localds == null) return;
        else Localds.writeInt("Img", img);}
    public Item getItems() {
        if (Localds == null) return null;
        else return new Item(
                Localds.getInt("Img"),
                Localds.getString("Name")
        );
    }

    private AppDatabase db;
    public void createDatabase(Context context, Map<String, Integer> values) {
        if (db != null) return;
        db = Room.databaseBuilder(context,
                AppDatabase.class, "List").allowMainThreadQueries().build();
        ListDAO listDAO = db.listDAO();

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            insertCategory(entry.getKey(), entry.getValue());
        }
    }
    public Category getCategory(String itemName){
        return db.listDAO().getCategoryByName(itemName);
    }
    public void insertCategory(String compName, int img){
        Category category = new Category();
        category.compName = compName;
        category.img = img;
        db.listDAO().insertCategory(category);

    }
}
