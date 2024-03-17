"use strict";

const heading = document.querySelector("h1");
const analogClock = document.querySelector(".analog");
const digitalClock = document.querySelector(".digital");
const hour = document.querySelector(".hour");
const minute = document.querySelector(".minute");
const second = document.querySelector(".second");

(function init() {
  digitalClock.classList.add("hidden");
  heading.textContent = "Analog Clock";
})();

const showAnalogClock = function (date) {
  const hr = date.getHours();
  const min = date.getMinutes();
  const sec = date.getSeconds();
  // hour rotates 30 degrees per hour plus additional rotation for minutes (i.e. 30mins = 1/2 hr)
  const hr_rotation = 30 * hr + min / 2;
  const min_rotation = 6 * min;
  const sec_rotation = 6 * sec;
  // console.log(hr, min, sec, hr_rotation, min_rotation, sec_rotation);
  hour.style.transform = `rotate(${hr_rotation}deg)`;
  minute.style.transform = `rotate(${min_rotation}deg)`;
  second.style.transform = `rotate(${sec_rotation}deg)`;
};

const showDigitalClock = function (date) {
  digitalClock.innerHTML = date.toLocaleTimeString();
};

const currentTime = function () {
  const date = new Date();
  showDigitalClock(date);
  showAnalogClock(date);
};
setInterval(currentTime, 1000);

const showClock = function () {
  if (digitalClock.classList.contains("hidden")) {
    digitalClock.classList.remove("hidden");
    heading.textContent = "Digital Clock";
  } else digitalClock.classList.add("hidden");
  if (analogClock.classList.contains("hidden")) {
    analogClock.classList.remove("hidden");
    analogClock.classList.add("analog");
    heading.textContent = "Analog Clock";
  } else {
    analogClock.classList.add("hidden");
    analogClock.classList.remove("analog");
  }
};

document.querySelector("body").addEventListener("click", showClock);
