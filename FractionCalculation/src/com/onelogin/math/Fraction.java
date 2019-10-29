package com.onelogin.math;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {

    }

    public Fraction(int numerator, int denominator) {

        if (denominator == 0 || numerator == 0) {
            throw new IllegalArgumentException("wrong fraction");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction that) {
        int common = this.denominator * that.denominator;
        return new Fraction(this.numerator * that.denominator + that.numerator * this.denominator, common);
    }

    public Fraction subtract(Fraction that) {
        int common = this.denominator * that.denominator;
        return new Fraction(this.numerator * that.denominator - that.numerator * this.denominator, common);
    }

    public Fraction multiply(Fraction that) {
        return new Fraction(this.numerator * that.numerator, this.denominator * that.denominator);
    }

    public Fraction divide(Fraction that) {
        return new Fraction(this.numerator * that.denominator, this.denominator * that.numerator);
    }

    public String toString() {
        reduce();
        int n = numerator % denominator;
        int d = denominator;
        int wholeNumber = (numerator - n) / denominator;

        StringBuilder sb = new StringBuilder();
        if (wholeNumber > 0) {
            sb.append(wholeNumber);
        }
        if (n > 0) {
            if (sb.length() > 0) {
                sb.append("_");
            }
            sb.append(n).append("/").append(d);
        }
        return sb.toString();
    }

    private void reduce() {
        int common;
        int n = Math.abs(this.numerator);
        int d = Math.abs(this.denominator);
        if (n > d) {
            common = greatestCommonDenominator(n, d);
        } else if (n < d) {
            common = greatestCommonDenominator(d, n);
        } else {
            common = n;
        }

        this.numerator = n / common;
        this.denominator = d / common;
    }

    private int greatestCommonDenominator(int thisDen, int thatDen) {
        int factor;
        while (thatDen != 0) {
            factor = thatDen;
            thatDen = thisDen % thatDen;
            thisDen = factor;
        }
        return thisDen;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
