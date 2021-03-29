const baseUrl = "http://localhost:3000";

const api = {
  get: (url) =>
    fetch(`${baseUrl}${url}`)
      .then((response) => response.json())
      .then((data) => data),
  put: (url, data) => console.log("test", test),
};

export default api;
