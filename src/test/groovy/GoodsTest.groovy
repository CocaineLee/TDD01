import spock.lang.Specification

class GoodsTest extends Specification {

  def "we can calculate next day quality"() {
    given:
      def normalGoods = new Goods(2, 40, GoodsType.NORMAL);

    when:
      Goods nextDay = normalGoods.next();

    then:
      nextDay.getQuality() == 39;

  }
}
