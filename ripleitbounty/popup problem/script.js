const audienceSizeSlider = document.getElementById("audience-size");
const premiumRatioSlider = document.getElementById("premium-ratio");
const fanEngagementSlider = document.getElementById("fan-engagement");

const audienceSizeValue = document.getElementById("audience-size-value");
const premiumRatioValue = document.getElementById("premium-ratio-value");
const fanEngagementValue = document.getElementById("fan-engagement-value");

const totalRoyalties = document.getElementById("total-royalties");

function calculateRoyalties() {
  const audienceSize = parseInt(audienceSizeSlider.value);
  const premiumRatio = parseInt(premiumRatioSlider.value) / 100;
  const fanEngagement = parseInt(fanEngagementSlider.value) / 100;

  const royalties = audienceSize * premiumRatio * fanEngagement;
  totalRoyalties.textContent = `$${royalties.toFixed(2)}`;
}

function updateSliderLabels() {
  const numberFormat = new Intl.NumberFormat("en-US");
  audienceSizeValue.textContent = numberFormat.format(audienceSizeSlider.value);
  premiumRatioValue.textContent = `${premiumRatioSlider.value}%`;
  fanEngagementValue.textContent = `${fanEngagementSlider.value}%`;
}

audienceSizeSlider.addEventListener("input", () => {
  updateSliderLabels();
  calculateRoyalties();
});

premiumRatioSlider.addEventListener("input", () => {
  updateSliderLabels();
  calculateRoyalties();
});

fanEngagementSlider.addEventListener("input", () => {
  updateSliderLabels();
  calculateRoyalties();
});

// Initialize the calculator with default values
calculateRoyalties();

function hidePopups() {
  const popups = document.querySelectorAll('.popup');
  popups.forEach(popup => {
    popup.style.display = 'none';
  });
}
// const helpIcons = document.querySelectorAll('.help-icon');

// helpIcons.forEach(icon => {
//     icon.addEventListener('mouseenter', () => {
//         const popupId = icon.getAttribute('data-popup');
//         const popupElement = document.getElementById(popupId);
//         popupElement.classList.add('show');
//     });

//     icon.addEventListener('mouseleave', () => {
//         const popupId = icon.getAttribute('data-popup');
//         const popupElement = document.getElementById(popupId);
//         popupElement.classList.remove('show');
//     });
// });

