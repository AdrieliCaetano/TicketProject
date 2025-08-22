import api from "../services/api"
import type { IEvent, IEventCreate } from "../types/IEvent"

export async function getAllEvents(): Promise<IEvent[]> {
  return api<IEvent[]>("/events")
}

export async function getEventById(id: string): Promise<IEvent> {
  return api<IEvent>(`/events/${id}`)
}

export async function createEvent(event: IEventCreate): Promise<IEvent> {
  return api<IEvent>("/events", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(event),
  })
}

export async function updateEvent(data: Partial<IEvent>): Promise<IEvent> {
    return api<IEvent>(`/events`, {
      method: "put",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    })
}

export async function deleteEvent(id: string): Promise<IEvent> {
  return api<IEvent>("/events/remove", {
    method: "DELETE",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ id }),
  })
}


