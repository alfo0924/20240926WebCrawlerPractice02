

## MLBPlayoffs2022Crawler.java

這個程式使用Jsoup庫爬取MLB官網的2022年常規賽排名數據,並生成簡易的季後賽對陣圖。

### 主要組件

1. **main方法**
   - 調用`crawlMLBStandings()`獲取球隊勝場數據
   - 調用`printPlayoffBracket()`打印季後賽對陣圖
   - 使用try-catch處理可能的IOException

2. **crawlMLBStandings方法**
   - 使用Jsoup連接MLB官網並解析HTML
   - 提取每個球隊的縮寫和勝場數
   - 將數據存儲在Map<String, Integer>中

3. **printPlayoffBracket方法**
   - 定義美國聯盟和國家聯盟的球隊順序
   - 調用`printDivision()`方法分別打印兩個聯盟的對陣圖

4. **printDivision方法**
   - 根據提供的球隊順序和勝場數據打印對陣圖

### 關鍵點

- 使用Jsoup進行網頁爬取
- 使用Map存儲球隊數據
- 使用printf格式化輸出對陣圖

## MLBPlayoffs2022.java

這個程式直接使用預定義的數據生成2022年MLB季後賽對陣圖。

### 主要組件

1. **main方法**
   - 定義包含球隊名稱和勝場數的數組
   - 定義獲勝球隊的數組
   - 調用`printBracket()`方法打印對陣圖

2. **printBracket方法**
   - 接受球隊數組、獲勝者數組和起始/結束索引
   - 根據提供的數據打印對陣圖的一部分

### 關鍵點

- 使用預定義的數組存儲數據
- 使用字符串拼接和格式化輸出對陣圖
- 通過調整起始和結束索引來打印不同聯盟的對陣圖

## 比較

1. **數據來源**:
   - `MLBPlayoffs2022Crawler.java` 從網站實時爬取數據
   - `MLBPlayoffs2022.java` 使用預定義的靜態數據

2. **靈活性**:
   - `MLBPlayoffs2022Crawler.java` 更靈活,可以獲取最新數據
   - `MLBPlayoffs2022.java` 更簡單,但數據需要手動更新

3. **依賴**:
   - `MLBPlayoffs2022Crawler.java` 依賴Jsoup庫
   - `MLBPlayoffs2022.java` 不需要外部依賴

4. **錯誤處理**:
   - `MLBPlayoffs2022Crawler.java` 包含網絡錯誤處理
   - `MLBPlayoffs2022.java` 不需要錯誤處理
