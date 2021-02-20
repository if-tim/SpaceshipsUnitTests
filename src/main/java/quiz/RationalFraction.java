package itis.quiz;


/*
	Это класс-представление рациональной дроби. Вам необходимо реализовать все методы приведенные ниже, для работы с ним.
	Вы можете добавлять собственные служебные внутренние методы, но не можете менять или удалять существующие.
	Для вашего удобства конструктор, геттеры и сеттеры уже есть.
	!МЕНЯТЬ СИГНАТУРЫ И ТИПЫ ВОЗВРАЩАЕМЫХ ЗНАЧЕНИЙ НЕЛЬЗЯ!
 */
public class RationalFraction {

    private int numerator;

    private int denominator;

    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //сокращает дробь, насколько это возможно
    void reduce(){
        for (int i = 2; i < Math.min(numerator, denominator); i++) {
            if(numerator % i == 0 && denominator % i ==0) {
                numerator /= i;
                denominator /= i;
            }
        }
    }
    //сравнивает с другой дробью (не забудьте про сокращение!)
    public boolean equals(RationalFraction otherFraction) {
        this.reduce();
        otherFraction.reduce();
        if(this.numerator == otherFraction.getNumerator() && this.denominator == otherFraction.getDenominator()) {
            return true;
        }
        return false;
    }
    //Текстовое представление дроби
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
    //перевод в десятичную дробь
    public Double toDecimalFraction(){
        double n = numerator;
        double d = denominator;
        return n / d;
    }
    //выделение целой части
    public Integer getNumberPart(){
        return this.numerator/this.denominator;
    }
    //сложение с другой дробью (не забудьте про сокращение здесь и во всех остальных математических операциях)
    public RationalFraction add(RationalFraction otherFraction){
        RationalFraction result = new RationalFraction((this.numerator * otherFraction.getDenominator()) +
                otherFraction.getNumerator() * this.denominator, denominator * otherFraction.getDenominator());
        return result;
    }
    //вычитание другой дроби
    public RationalFraction sub(RationalFraction otherFraction){
        RationalFraction result = new RationalFraction((this.numerator * otherFraction.getDenominator()) -
                otherFraction.getNumerator() * this.denominator,this.denominator * otherFraction.getDenominator());
        return result;
    }
    //умножение на другую дробь
    public RationalFraction multiply(RationalFraction otherFraction){
        RationalFraction result = new RationalFraction(this.numerator * otherFraction.getNumerator(),
                this.denominator * otherFraction.denominator);
        return result;
    }
    //деление на другую дробь
    public RationalFraction divide(RationalFraction otherFraction){
        RationalFraction result = new RationalFraction(this.numerator * otherFraction.getDenominator(),
                this.denominator * otherFraction.getNumerator());
        return result;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
