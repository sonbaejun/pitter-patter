import { userApi } from "/src/apiService.js";

export const signUp = async (data) => {
  const response = await userApi.post("/email", data);
  return response;
};

export const checkDuplicateEmail = async (email) => {
  const response = await userApi.get("/check/email", {
    params: { email },
  });
  return response;
};

export const login = async (data) => {
  const response = await userApi.post("/login", data);
  return response;
};
