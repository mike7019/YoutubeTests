package com.co.konex.test.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class SearchOnYoutubeModel {

    protected String song;

    public static List<SearchOnYoutubeModel> setData(DataTable table){
        List<SearchOnYoutubeModel> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();
        for (Map<String, String> map: mapInfo){
            data.add(new ObjectMapper().convertValue(map, SearchOnYoutubeModel.class));
        }
        return data;
    }

}
