// Fetch AEM banner content via server-side proxy
window.addEventListener('DOMContentLoaded', async () => {
  const banner = document.getElementById('aemBanner');
  if (banner) {
    try {
      const res = await fetch('aem/banner');
      const text = await res.text();
      banner.textContent = text.trim();
    } catch (e) {
      banner.textContent = "Welcome to the Community Blood Donation System";
    }
  }
});
