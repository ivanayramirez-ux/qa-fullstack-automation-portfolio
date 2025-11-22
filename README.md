<h1>🚀 QA Fullstack Automation Portfolio</h1>

<p>
Multi-module Maven project showcasing my QA automation skills across UI testing, shared core utilities, and reporting 
<strong>(TestNG + Allure)</strong>.
</p>

<h2>📦 Current Modules</h2>
<ul>
  <li><strong>core</strong> – shared utilities (config, drivers, waits, reporting + Allure listener)</li>
  <li><strong>ui-orangehrm</strong> – Selenium + TestNG UI automation for the OrangeHRM demo site</li>
</ul>

<p>More modules (API, performance, accessibility) will be added later.</p>

<hr>

<h2>📁 Project Structure</h2>

<pre>
qa-fullstack-automation-portfolio/
│
├── pom.xml                         # parent Maven pom
├── core/                           # shared utilities
│   ├── pom.xml
│   └── src/main/java/com/ivana/core/
│       ├── config/                 # Config + environment handling
│       ├── drivers/                # WebDriver factory / lifecycle
│       ├── utils/                  # Wait utilities, helpers
│       └── reporting/              # TestNG + Allure reporting helper
│
└── ui-orangehrm/                   # Selenium UI tests for OrangeHRM
    ├── pom.xml
    ├── testng.xml                  # TestNG suite (smoke, pim, leave groups)
    ├── config/
    │   ├── config-local.properties
    │   ├── config-dev.properties
    │   └── config-stage.properties
    ├── src/
    │   ├── main/java/com/ivana/orangehrm/pages/
    │   └── test/java/com/ivana/orangehrm/tests/
    ├── reports/                    
    ├── allure-results/             
    └── allure-report/              
</pre>

<hr>

<h2>🧩 Core Module</h2>

<p><strong>Path: core/</strong><br>Shared utilities used by all modules.</p>

<h3>🔧 Components</h3>

<h4>⚙️ ConfigManager</h4>
<ul>
  <li>Loads <code>config-*.properties</code> files</li>
  <li>Provides <code>ConfigManager.get("key")</code></li>
  <li>Used by BaseUITest for URLs, credentials, timeouts</li>
</ul>

<h4>🛠️ DriverFactory</h4>
<ul>
  <li>Creates and quits WebDriver instances</li>
  <li>Uses ChromeDriver + WebDriverManager</li>
  <li><code>getDriver()</code> returns a ready WebDriver</li>
</ul>

<h4>⏳ WaitUtils</h4>
<ul>
  <li>Implicit + page load timeouts</li>
  <li>Reusable explicit waits (e.g. <code>waitForClickable</code>)</li>
</ul>

<h4>📝 ReportManager</h4>
<ul>
  <li>Cleans up logging flow for TestNG</li>
  <li>Useful for listeners or custom reporting</li>
</ul>

<h4>✨ AllureTestListener</h4>
<ul>
  <li>Captures test start/end/success/failure</li>
  <li>Sends logs + steps to Allure</li>
  <li>Outputs JSON into <code>allure-results/</code></li>
</ul>

<hr>

<h2>🖥️ OrangeHRM UI Module</h2>

<p><strong>Path: ui-orangehrm/</strong><br>Selenium UI automation using Page Object Model + TestNG.</p>

<h3>🛠️ Tech Stack</h3>
<ul>
  <li>Java</li>
  <li>Selenium WebDriver 4</li>
  <li>TestNG 7</li>
  <li>WebDriverManager</li>
  <li>Maven Surefire</li>
  <li>Allure Reporting</li>
</ul>

<hr>

<h2>📄 Page Objects</h2>

<p>All pages extend <strong>BasePage</strong> which provides:</p>
<ul>
  <li>Driver access</li>
  <li>Reusable click + type helpers</li>
  <li>Wait utilities</li>
</ul>

<h3>🔐 LoginPage</h3>
<ul>
  <li>Username, password, login button locators</li>
  <li>Fluent methods: <code>enterUsername()</code>, <code>enterPassword()</code>, <code>clickLogin()</code></li>
</ul>

<h3>📊 DashboardPage</h3>
<ul>
  <li>PIM, Leave, user menu</li>
  <li>Actions: <code>goToPIM()</code>, <code>goToLeave()</code>, <code>logout()</code></li>
</ul>

<h3>👤 PIMPage</h3>
<ul>
  <li>Add employee workflow</li>
  <li>Future space for search/verification</li>
</ul>

<h3>📝 LeavePage</h3>
<ul>
  <li>Leave apply workflow</li>
  <li>Type → Date range → Comment → Submit</li>
</ul>

<hr>

<h2>🧪 Test Base</h2>

<h3>BaseUITest</h3>
<ul>
  <li><strong>@BeforeMethod</strong> loads config, sets up driver, applies waits</li>
  <li><strong>@AfterMethod</strong> quits driver cleanly</li>
  <li>All tests extend this base</li>
</ul>

<hr>

<h2>🧫 Test Classes</h2>

<h3>🔥 OrangeHRMLoginTest <em>(smoke)</em></h3>
<ul>
  <li>Login using config credentials</li>
  <li>Verify the login success</li>
</ul>

<h3>👥 EmployeeManagementTests <em>(smoke + pim)</em></h3>
<ul>
  <li>Login → PIM → Add Employee</li>
  <li>Assertion hooks included</li>
</ul>

<h3>🌴 LeaveRequestTests <em>(leave + regression)</em></h3>
<ul>
  <li>Login → Apply Leave → Assert success</li>
</ul>

<hr>

<h2>🧰 TestNG Suite</h2>

<pre>
File: ui-orangehrm/testng.xml

Groups:
  - smoke
  - pim
  - leave
</pre>

<p>You can run different groups via IDE or CI.</p>

<hr>

<h2>📊 Reports</h2>

<h3>1️⃣ Maven / TestNG HTML Reports</h3>

<p><strong>Location:</strong> ui-orangehrm/reports/</p>

<p>Includes:</p>
<ul>
  <li>index.html (dashboard)</li>
  <li>XML results</li>
  <li>emailable-report.html</li>
</ul>

<h3>2️⃣ Allure Reports</h3>

<p><strong>Raw:</strong> ui-orangehrm/allure-results/</p>
<p><strong>HTML:</strong> ui-orangehrm/allure-report/ (ignored in Git)</p>

<pre>
allure serve ui-orangehrm/allure-results
</pre>

<p>Shows interactive dashboard: steps, attachments, history, logs.</p>

<hr>

<h2>▶️ Running Tests</h2>

<h3>1. Run Everything</h3>

<pre>
cd qa-fullstack-automation-portfolio
mvn clean install
</pre>

<h3>2. Run Only UI Tests</h3>

<pre>
cd ui-orangehrm
mvn test
</pre>

<h3>3. IDE (TestNG)</h3>

<p>Right-click <strong>testng.xml</strong> → Run.</p>

<hr>

<h2>🧹 Repo Hygiene</h2>

<h3>In core/</h3>
<strong>Keep:</strong>
<ul>
  <li>src/main/java</li>
  <li>src/main/resources</li>
  <li>src/test/java</li>
  <li>pom.xml</li>
</ul>

<strong>Generated (ignored):</strong>
<ul>
  <li>target/</li>
  <li>test-output/</li>
</ul>

<h3>In ui-orangehrm/</h3>

<strong>Keep:</strong>
<ul>
  <li>src/main/java/…</li>
  <li>src/test/java/…</li>
  <li>config/</li>
  <li>reports/</li>
  <li>allure-results/</li>
</ul>

<strong>Ignored:</strong>
<ul>
  <li>target/</li>
  <li>test-output/</li>
  <li>allure-report/</li>
</ul>

<h3>Root Project</h3>
<ul>
  <li>Keep: root pom.xml, core/, ui-orangehrm/</li>
  <li>Delete empty src/ or build folders</li>
</ul>

<hr>

<h2>🛣️ Roadmap</h2>

<ul>
  <li><strong>API Testing Module</strong> – RestAssured, JSON schema validation</li>
  <li><strong>Performance Module</strong> – JMeter/BlazeMeter load + stress tests</li>
  <li><strong>Accessibility</strong> – axe DevTools, basic WCAG/508 checks</li>
  <li><strong>Cross-browser + Parallel</strong> – Selenium Grid, BrowserStack, Sauce Labs</li>
</ul>

<p>
Everything new will plug into the existing <strong>core</strong> utilities so the architecture stays consistent and easy to extend.
</p>
