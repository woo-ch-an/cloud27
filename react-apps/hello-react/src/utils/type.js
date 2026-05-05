/** @format */
export const isString = (value) => {
    if (value) {
        return typeof value === "string";
    }
    // else Return 업는 이유 : undefined 이 알아서 감, false랑 작동이 같으니 상관없음
};

export const isNumber = (value) => {
    if (value) {
        return typeof value === "number";
    }
};

export const isObject = (value) => {
    if (value) {
        return typeof value === "object" && Array.isArray(value) === false;
    }
};

export const isArray = (value) => {
    if (value) {
        return Array.isArray(value);
    }
};

export const isFunction = (value) => {
    if (value) {
        return typeof value === "function";
    }
};