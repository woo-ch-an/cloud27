import { isArray, isObject } from "./type";

export const getValidationResult = (error) => {
    if (isArray(error)) {
        const message = {};

        for (let eachError of error) {
            if (isObject(eachError)) {
                if (eachError.field && eachError.defaultMessage) {
                    message[eachError.field] = eachError.defaultMessage;
                }
                else {
                    return undefined;
                }
            }
            else {
                return undefined;
            }
        }

        return message;
    }
};

