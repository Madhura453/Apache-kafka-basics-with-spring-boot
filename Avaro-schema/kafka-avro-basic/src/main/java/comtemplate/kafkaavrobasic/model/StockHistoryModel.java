package comtemplate.kafkaavrobasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockHistoryModel {

    private int tradeQuantity;
    private String tradeMarket;
    private String stockName;
    private String tradeType;
    private float price;
    private float amount;
}
