using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace dsp086.Practica_04
{
    [TestClass]
    public class EAritmeticaUnitTest
    {
        [TestMethod]
        public void InfijaAPostfijaSimple()
        {
            EAritmetica ea = new EAritmetica();
            String expected = "4.0 5.0 * 4.0 6.0 + /";
            String expresion = ea.InfijaToPostfija("4.0 * 5.0 / ( 4.0 + 6.0 )");
            Assert.AreEqual(expected, expresion);
        }

        [TestMethod]
        public void InfijaAPostfijaAvanzada()
        {
            EAritmetica ea = new EAritmetica();
            String expected = "4.0 5.0 6.0 + 8.0 2.0 3.0 ^ / - 7.0 - * 1.0 -";
            String expresion = ea.InfijaToPostfija("4.0 * ( 5.0 + 6.0 - ( 8.0 / 2.0 ^ 3.0 ) - 7.0 ) - 1.0");
            Assert.AreEqual(expected, expresion);
        }

        [TestMethod]
        public void EvaluacionAritmeticaSimple()
        {
            EAritmetica ea = new EAritmetica();
            double expected = 2.0;
            double result = ea.EvaluaPostfija(ea.InfijaToPostfija("4.0 * 5.0 / ( 4.0 + 6.0 )"));
            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void EvaluacionAritmeticaAvanzada()
        {
            EAritmetica ea = new EAritmetica();
            double expected = 11.0;
            double result = ea.EvaluaPostfija(ea.InfijaToPostfija("4.0 * ( 5.0 + 6.0 - ( 8.0 / 2.0 ^ 3.0 ) - 7.0 ) - 1.0"));
            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void EvaluacionAritmeticaConDecimales()
        {
            EAritmetica ea = new EAritmetica();
            double expected = 15.75;
            double result = ea.EvaluaPostfija(ea.InfijaToPostfija("4.5 * 3.5"));
            Assert.AreEqual(expected, result);
        }
    }
}
