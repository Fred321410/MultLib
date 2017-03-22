import { MultLibPage } from './app.po';

describe('mult-lib App', () => {
  let page: MultLibPage;

  beforeEach(() => {
    page = new MultLibPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
