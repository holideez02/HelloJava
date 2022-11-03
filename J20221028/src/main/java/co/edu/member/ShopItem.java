package co.edu.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopItem {
	private String itemCode;
	private String itemName;
	private int originPrice;
	private int salePrice;
	private double likeIt; //평점
	private String image;
}
