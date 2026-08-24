"use strict";

const heading = document.querySelector("h1");
const analogClock = document.querySelector(".analog");
const digitalClock = document.querySelector(".digital");
const toggleButton = document.querySelector("#toggle-clock");
const hourHand = document.querySelector(".hour");
const minuteHand = document.querySelector(".minute");
const secondHand = document.querySelector(".second");

const updateClock = () => {
  const now = new Date();
  const hours = now.getHours();
  const minutes = now.getMinutes();
  const seconds = now.getSeconds();

  hourHand.style.transform = `rotate(${30 * hours + minutes / 2}deg)`;
  minuteHand.style.transform = `rotate(${6 * minutes}deg)`;
  secondHand.style.transform = `rotate(${6 * seconds}deg)`;
  digitalClock.textContent = now.toLocaleTimeString();
};

const toggleClock = () => {
  const showDigital = digitalClock.classList.contains("hidden");
  digitalClock.classList.toggle("hidden", !showDigital);
  analogClock.classList.toggle("hidden", showDigital);
  heading.textContent = showDigital ? "Digital Clock" : "Analog Clock";
  toggleButton.textContent = showDigital
    ? "Switch to analog clock"
    : "Switch to digital clock";
};

toggleButton.addEventListener("click", toggleClock);
updateClock();
setInterval(updateClock, 1000);
