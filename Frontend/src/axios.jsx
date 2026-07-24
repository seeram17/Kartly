// ============================================================
// DAY 2 — COMMIT 19: Axios instance (paired with AppContext)
// ============================================================
import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});
delete API.defaults.headers.common["Authorization"];
export default API;
