public class Goods {

  private Integer sellIn;

  private Integer quality;

  private GoodsType goodsType;

  public Goods(Integer sellIn, Integer quality, GoodsType goodsType) {
    this.sellIn = sellIn;
    this.quality = quality;
    this.goodsType = goodsType;
  }

  public Integer getQuality() {
    return quality;
  }

  public Goods next() {
    Integer depreciate = 1;
    if (this.sellIn <= 0) {
      depreciate *= 2;
    }
    this.sellIn -= 1;
    this.quality -= depreciate;
    return this;
  }
}
