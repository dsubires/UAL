using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections;
using dsp086.Practica_02;

namespace dsp086.Practica_02
{


    /// <summary>
    ///This is a test class for UsuarioTest and is intended
    ///to contain all UsuarioTest Unit Tests
    ///</summary>
    [TestClass()]
    public class UsuarioComparableTest
    {


        private TestContext testContextInstance;

        /// <summary>
        ///Gets or sets the test context which provides
        ///information about and functionality for the current test run.
        ///</summary>
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }




        #region Test de objetos iguales


        ///</summary>
        [TestMethod()]
        // método CompareTo. Objetos iguales.
        public void CompareTo_SameObjects_AreEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            UsuarioView userB = userA;

            int expected = 0;
            int actual = userA.CompareTo(userB);
            Assert.AreEqual(expected, actual);

        }



        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= . Objetos iguales.
        public void OperatorGreaterOrEqual_SameObjects_IsTrue()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = userA >= userB;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > . Objetos iguales.
        public void OperatorGreater_SameObjects_IsFalse()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = userA > userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Objetos iguales.
        public void OperatorLess_SameObjects_IsFalse()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = userA < userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Objetos iguales.
        public void OperatorLessOrEqual_SameObjects_IsTrue()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = userA <= userB;
            Assert.IsTrue(actual);

        }
        #endregion


        #region Test de valores iguales


        ///</summary>
        [TestMethod()]
        // método CompareTo. Valores iguales.
        public void CompareTo_DifferentObjectsWithSameId_AreEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            int expected = 0;
            int actual = userA.CompareTo(userB);
            Assert.AreEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= . Valores iguales.
        public void OperatorGreaterOrEqual_DifferentObjectsWithSameId_IsTrue()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA >= userB;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > . Valores iguales.
        public void OperatorGreater_DifferentObjectsWithSameId_IsFalse()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);


            bool actual = userA > userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Valores iguales.
        public void OperatorLess_DifferentObjectsWithSameId_IsFalse()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA < userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Valores iguales.
        public void OperatorLessOrEqual_DifferentObjectsWithSameId_IsTrue()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA <= userB;
            Assert.IsTrue(actual);

        }
        #endregion


        #region Comparación de valores Mayores por la derecha


        ///</summary>
        [TestMethod()]
        //método CompareTo. Valores mayor derecha
        public void CompareTo_GreaterObjectId_IsLess()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            int expected = -1;
            int actual = userA.CompareTo(userB);
            Assert.AreEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= .Valores mayor derecha
        public void OperatorGreaterOrEqual_GreaterObjectIdRight_IsFalse()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA >= userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > .Valores mayor derecha

        public void OperatorGreater_GreaterObjectIdRight_IsFalse()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA > userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Valores mayor derecha

        public void OperatorLower_LessObjectIdLeft_IsTrue()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA < userB;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Valores mayor derecha
        public void OperatorLowerOrEqual_GreaterObjectIdRight_IsTrue()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA <= userB;
            Assert.IsTrue(actual);

        }
        #endregion


        #region Comparación de valores Mayores por la izquierda


        ///</summary>
        [TestMethod()]
        //método CompareTo. Valores mayor izquierda.
        public void CompareTo_ObjectIdLower_IsGreater()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            int expected = 1;
            int actual = userA.CompareTo(userB);
            Assert.AreEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= . Valores mayor izquierda.

        public void OperatorGreaterOrEqual_ObjectIdLower_IsTrue()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA >= userB;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > . Valores mayor izquierda

        public void OperatorGreater_GreaterObjectIdLeft_IsTrue()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA > userB;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Valores mayor izquierda.

        public void OperatorLower_GreaterObjectIdLeft_IsFalse()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA < userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Valores mayor izquierda.

        public void OperatorLowerOrEqual_GreaterObjectIdLeft_IsFalse()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA <= userB;
            Assert.IsFalse(actual);

        }
        #endregion


        #region Comparación de valoresNulos por la izquierda


        ///</summary>
        [TestMethod()]
        //método CompareTo. Valores nulos izquierda.

        public void CompareTo_NullObject_IsGreater()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = null;

            int expected = 1;
            int actual = userA.CompareTo(userB);
            Assert.AreEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= . Valor null izquierda.

        public void OperatorGreaterOrEqual_NullObjectLeft_IsFalse()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;
            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA >= userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > . Valores null izquierda

        public void OperatorGreater_NullObjectLeft_IsFalse()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA > userB;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Valores null izquierda.

        public void OperatorLower_NullObjectLeft_IsTrue()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA < userB;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Valores null izquierda.

        public void OperatorLowerOrEqual_NullObjectLeft_IsTrue()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA <= userB;
            Assert.IsTrue(actual);

        }
        #endregion


        #region Comparación de valoresNulos por la derecha


        ///</summary>
        [TestMethod()]
        //método CompareTo. Valores nulos izquierda.
        public void CompareTo_NullObject_IsGrerater()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = null;

            int expected = 1;
            int actual = userA.CompareTo(userB);
            Assert.AreEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= . Valor null drecha.

        public void OperatorGreaterOrEqual_NullObjectRight_IsTrue()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;
            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userB >= userA;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > . Valores null drerecha

        public void OperatorGreater_NullObjectRight_IsTrue()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userB > userA;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Valores null derecha.

        public void OperatorLower_NullObjectRight_IsFalse()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userB < userA;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Valores null derecha.

        public void OperatorLowerOrEqual_NullObjectRight_IsFalse()
        {
            int i = 2;
            string snum = i.ToString();
            UsuarioView userA = null;

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userB <= userA;
            Assert.IsFalse(actual);

        }
        #endregion


        #region Comparación de valoresNulos ambos




        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador >= . Valor ambos null.

        public void OperatorGreaterOrEqual_BothNullObject_IsTrue()
        {
            UsuarioView userB = null;

            UsuarioView userA = null;

            bool expected = true;
            bool actual = userB >= userA;
            Assert.IsTrue(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador > . Valores ambos null
        public void OperatorGreater_BothNullObject_IsFalse()
        {
            UsuarioView userB = null;

            UsuarioView userA = null;

            bool expected = false;
            bool actual = userB > userA;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador < . Valores ambos null
        public void OperatorLower_BothNullObject_IsFalse()
        {
            UsuarioView userB = null;

            UsuarioView userA = null;



            bool expected = false;
            bool actual = userB < userA;
            Assert.IsFalse(actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador <= . Valores ambos null

        public void OperatorLowerOrEqual_BothNullObject_IsTrue()
        {
            UsuarioView userB = null;

            UsuarioView userA = null;


            bool expected = true;
            bool actual = userB <= userA;
            Assert.IsTrue(actual);

        }
        #endregion



    }
}

