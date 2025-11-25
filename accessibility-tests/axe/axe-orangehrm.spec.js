import { test, expect } from '@playwright/test';
import AxeBuilder from '@axe-core/playwright';

test('OrangeHRM accessibility scan', async ({ page }) => {
  await page.goto('https://opensource-demo.orangehrmlive.com/');

  const results = await new AxeBuilder({ page }).analyze();

  console.log('Accessibility violations:', results.violations);

  // For portfolio it’s fine if this fails because of real issues.
  // If you want the test to always pass but still show findings,
  // comment out the assertion below.
  expect(results.violations.length).toBe(0);
});
