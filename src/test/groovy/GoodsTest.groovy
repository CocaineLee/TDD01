import spock.lang.Specification

class GoodsTest extends Specification {

  def "we can calculate next day quality before expiring"() {
    given:
      def normalGoods = new Goods(2, 40, GoodsType.NORMAL);

    when:
      Goods nextDay = normalGoods.calculateNextDayQuality();

    then:
      nextDay.getQuality() == 39;

  }

  def "we can calculate next day quality after expiring"() {
    given:
      def normalGoods = new Goods(0, 40, GoodsType.NORMAL);

    when:
      Goods nextDay = normalGoods.calculateNextDayQuality();

    then:
      nextDay.getQuality() == 38;

  }

  def "we can calculate next day of BACKSTAGE_PASS quality before 10 expiring "() {
    given:
      def normalGoods = new Goods(12, 40, GoodsType.BACKSTAGE_PASS);

    when:
      Goods nextDay = normalGoods.calculateNextDayQuality();

    then:
      nextDay.getQuality() == 41;
  }

  def "we can calculate next day of BACKSTAGE_PASS quality before 5-10 expiring "() {
    given:
      def normalGoods = new Goods(6, 40, GoodsType.BACKSTAGE_PASS);

    when:
      Goods nextDay = normalGoods.calculateNextDayQuality();

    then:
      nextDay.getQuality() == 42;
  }

  def "we can calculate next day of BACKSTAGE_PASS quality before 0-5 expiring "() {
    given:
      def normalGoods = new Goods(3, 40, GoodsType.BACKSTAGE_PASS);

    when:
      Goods nextDay = normalGoods.calculateNextDayQuality();

    then:
      nextDay.getQuality() == 43;
  }

  def "we can calculate next day of BACKSTAGE_PASS quality after expiring "() {
    given:
      def normalGoods = new Goods(0, 40, GoodsType.BACKSTAGE_PASS);

    when:
      Goods nextDay = normalGoods.calculateNextDayQuality();

    then:
      nextDay.getQuality() == 0;
  }

}
