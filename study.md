json 파일 쓰기

    // json 파일을 json 형태로 추가할 때
    JSONObject obj = new JSONObject();
    obj.put("name", "mine-it-record");
    obj.put("mine", "GN");
    obj.put("year", 2021);
    try {
        FileWriter file = new FileWriter("c:/mine_data/mine.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    // 일반 배열의 값을 JSONObject로 넣을 때
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    try {
        FileWriter file = new FileWriter("c:/mine_data/mine.json");
        file.write(list.toString());
        file.flush();
        file.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    

json 파일 읽기

    JSONParser parser = new JSONParser();
    try {
        // 일반 json 파일을 읽을 때
        FileReader reader = new FileReader("c:/mine_data/mine.json");
        Object obj = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) obj; 
        reader.close();
    } catch (IOException | ParseException e) {
    
        e.printStackTrace();
    }

