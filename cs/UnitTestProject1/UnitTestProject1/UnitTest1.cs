using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace UnitTestProject1
{
    [TestClass]
    public class TechblogLoginTest
    { 
    
        /* private IWebDriver driver;
        private string uri = "https:techblog.polteq.com/testshop";

         [TestInitialize]
           public void TestSetup()
        {
            
            driver.Navigate().GoToUrl(uri);
            driver.Manage().Window.Maximize();
            // driver.Manage().Timeouts().ImplicitlyWait(new TimeSpan(0, 0, 0, 10));
        }

        [TestCleanup]
        public void Cleanup()
        {
           driver.Quit();
        } */

        [TestMethod]
        public void LoginAsUser()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https:techblog.polteq.com/testshop");
            driver.Manage().Window.Maximize();
            driver.FindElement(By.ClassName("login")).Click();
            driver.FindElement(By.Id("email")).SendKeys("anna.tester@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("Welkom123!");
            driver.FindElement(By.Id("SubmitLogin")).Click();
        }
        [TestMethod]
        public void IsLoggedIn()
        {
            bool isLoggedIn = false;
            Assert.IsTrue(isLoggedIn, "After entering username and password I should be logged in ");

            //String infoAccount = driver.FindElement(By.ClassName("info-account")).GetText();
            // Assertions.assertThat(infoAccount).as ("Welcome message contains").contains("Welcome to your account.");

        }

        [TestMethod]
        public void CheckWelcomeStringStartsWith()
        {
            string welcomeText = "Welcome to your account.";
            StringAssert.StartsWith(welcomeText, "Test", "First comes Welcome");
        }

    }

}
 