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
    this.sellIn -= 1;
    this.quality = this.quality - 1;
    return this;
  }
}
