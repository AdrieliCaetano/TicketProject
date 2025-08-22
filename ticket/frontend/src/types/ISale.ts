import type { IEvent } from "./IEvent"
import type { IUser } from "./IUser";

export interface ISaleRaw {
    id: string,
    user_id: string,
    event: IEvent,
    saleDate: string,
    saleStatus: string,
    createdAt: string,
    updatedAt: string
}

export type ISale = ISaleRaw & { user: IUser };
export type ISaleCreate = Partial<Omit<ISaleRaw, "id" | "createdAt" | "updatedAt" | "event">> & {event_id: string}
export type ISaleUpdate = Partial<Omit<ISaleRaw,  "updatedAt" | "event">> & {event_id: string}