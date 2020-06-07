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

  public Goods calculateNextDayQuality() {
    Integer depreciate;
    switch (this.goodsType) {
      case NORMAL:
        depreciate = calculateNormalDepreciate();
        break;
      default:
        depreciate = calculatePassDepreciate();
        break;
    }

    this.sellIn -= 1;
    this.quality -= depreciate;
    return this;
  }

  private Integer calculatePassDepreciate() {
    Integer depreciate = -1;
    if (this.sellIn <= 10 && this.sellIn >5) {
      depreciate = -2;
    }
    else if (this.sellIn <= 5 && this.sellIn > 0) {
      depreciate = -3;
    } else if (this.sellIn <= 0) {
      depreciate = this.quality;
    }
    return depreciate;
  }

  private Integer calculateNormalDepreciate() {
    Integer depreciate = 1;
    return this.sellIn > 0? depreciate: 2*depreciate;
  }
}
