import {Element, Library} from "./index";
export class Tag {
  constructor(
    public tagName: string,
    public tagDescription: string,
    public ownedByLibrary: Library[],
    public ownedBy?: Element[],
    public tagId?: number
  ){}
}
