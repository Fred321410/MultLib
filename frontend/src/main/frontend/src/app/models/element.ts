import { Library, Tag } from "./index";;
export class Element {
  constructor(
    public elementName: string,
    public elementDescription: string,
    public ownedBy: Library,
    public tags?: Tag[],
    public elementId?: number
  ){}
}
